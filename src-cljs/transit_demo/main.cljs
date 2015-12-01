(ns transit-demo.main
  (:require [ajax.core :refer [GET transit-response-format]]
            [clojure.browser.dom :as dom]
            [cognitect.transit :as transit]
            [transit-demo.domain.book :refer [new-book]]
            [transit-demo.impl :as impl]
            [transit-demo.util.transit :as ut]))

(def custom-reader
  (transit/reader :json {:handlers ut/custom-read-handlers}))

(defn find-book [callback]
  (GET "/api/books"
      {:handler callback
       :response-format (transit-response-format {:handlers ut/custom-read-handlers
                                                  :raw true})}))

(defn main []
  (find-book
   (fn [{:keys [books]}]
     (doseq [b books]
       (js/console.log (impl/tax-include-price b))))))

(main)
