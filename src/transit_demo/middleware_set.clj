(ns transit-demo.middleware-set
  (:require [environ.core :refer [env]]
            [immutant.internal.util :as iiu]
            [ring.middleware.defaults :as defaults]
            [ring.middleware.transit :as transit]
            [transit-demo.util.transit :as ut]))

(defn wrap-dev [handler]
  (let [wrap-reload (iiu/try-resolve 'ring.middleware.reload/wrap-reload)]
    (when wrap-reload
      (wrap-reload handler))))

(defn if-url-start-with [handler s middleware]
  (let [wrapped (middleware handler)]
    (fn [req]
      (if (.startsWith (:uri req) s)
        (wrapped req)
        (handler req)))))

(defn wrap-api-suite [handler prefix]
  (-> handler
      (if-url-start-with prefix #(-> %
                                     (transit/wrap-transit-body {:keywords? true})
                                     (transit/wrap-transit-response {:encoding :json :opts {:handlers ut/custom-write-handlers}})))))

(def wrap #'defaults/wrap)

(defn wrap-middleware-suite [handler]
  (-> handler
      (wrap wrap-dev (:dev env))
      (wrap wrap-api-suite "/api")
      (defaults/wrap-defaults defaults/site-defaults)))
