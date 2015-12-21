(ns transit-demo.handler.cart
  (:require [ajax.core :refer [GET transit-response-format]]
            [cognitect.transit :as transit]
            [re-frame.core :refer [register-handler
                                   path
                                   dispatch
                                   dispatch-sync]]
            [transit-demo.domain.cart :as cart]
            [transit-demo.routing :as r]
            [transit-demo.util.transit :as ut]))

;;; helpers

(def custom-reader
  (transit/reader :json {:handlers ut/custom-read-handlers}))

(defn book-search [callback]
  (GET (r/href :api/search-book)
      {:handler callback
       :response-format (transit-response-format {:handlers ut/custom-read-handlers
                                                  :raw true})}))

;;; event handlers

(def initial-state {:cart (cart/new-cart)
                    :books []})

(register-handler
 ::initialize
 (fn [db _]
   (let [merged (merge db initial-state)]
     (dispatch [::search-books])
     merged)))

(register-handler
 ::search-books
 (fn [db _]
   (book-search #(dispatch [::sync-books %]))
   db))

(register-handler
 ::sync-books
 (path [:books])
 (fn [books [_ res]]
   res))

(register-handler
 ::add-to-cart
 (path [:cart])
 (fn [cart [_ book]]
   (update cart :items #(conj % book))))
