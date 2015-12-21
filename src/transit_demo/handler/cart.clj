(ns transit-demo.handler.cart
  (:require [ring.util.response :as res]
            [transit-demo.util.handler :refer [defpagehandler]]
            [transit-demo.view.cart :as view]))

(defpagehandler cart :cart [req]
  (-> (view/cart)
      res/response))
