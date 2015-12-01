(ns transit-demo.core
  (:require [bidi.bidi :as bidi]
            [bidi.ring :as bidi-ring]
            [hiccup.core :as html]
            [hiccup.page :refer [html5 include-js]]
            [immutant.web :as web]
            [ring.middleware.defaults :as defaults]
            [ring.middleware.transit :as transit]
            [ring.util.response :as res]
            [transit-demo.domain.book :as book]
            [transit-demo.util.transit :as ut]))

;;; server
(defonce server (atom nil))

;;; handlers

(defn home-view []
  (html5
   [:head
    [:title "Transit Demo"]
    (include-js "/js/main.js")]
   [:body
    [:h1 "Hello, world!!"]]))

(defn home [req]
  (-> (home-view)
      res/response
      (res/content-type "text/html; charset=utf-8")))

;;; api handlers

(def ^:private books
  [(book/new-book "Clojure Programming" "Chas Emerick" 6648 "O'Reilly Media")
   (book/new-book "Clojure Cookbook" "Luke VanderHart" 4775 "O'Reilly Media")])

(defn find-book [req]
  (-> {:books books}
      res/response))

;;; middleware

(defn wrap-api-suite [handler]
  (-> handler
      (transit/wrap-transit-body {:keywords? true})
      (transit/wrap-transit-response {:encoding :json :opts {:handlers ut/custom-write-handlers}})))

;;; routes
(def main-routes
  ["/" {"" home
        "api" (bidi-ring/wrap-middleware
               {"/books" find-book}
               wrap-api-suite)}])

(def app
  (-> (bidi-ring/make-handler main-routes)
      (defaults/wrap-defaults defaults/site-defaults)))

(defn start []
  (when-not @server
    (reset! server (web/run #'app {:port 3000}))))

(defn stop []
  (when @server
    (web/stop {:port 3000})
    (reset! server nil)))
