(ns transit-demo.view.cart
  (:require [transit-demo.util.reframe :as ur]
            [transit-demo.view.component.cart :as component]
            [transit-demo.view.layout :as layout]))

(defn cart []
  (layout/common-layout
   [:h1 "Demo App"]
   [:div#cart-app
    (ur/render (component/app-component))]))
