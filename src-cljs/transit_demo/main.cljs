(ns transit-demo.main
  (:require [clojure.browser.dom :as dom]
            [re-frame.core :refer [dispatch-sync]]
            [transit-demo.handler.cart]
            [transit-demo.sub.cart]
            [transit-demo.impl :as impl]
            [transit-demo.view.component.cart :as c]
            [reagent.core :as reagent]))

(defn main []
  (when-let [elm (js/document.getElementById "cart-app")]
    (dispatch-sync [:transit-demo.handler.cart/initialize])
    (js/setInterval #(reagent/render [c/app-component] elm) 300)))

(defn reload []
  (main))

(main)
