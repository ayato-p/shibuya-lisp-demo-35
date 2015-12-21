(ns transit-demo.view.main
  (:require [transit-demo.routing :as r]
            [transit-demo.view.layout :as layout]))

(defn main []
  (layout/common-layout
   [:h1 "Lisp Meet Up presented by Shibuya.lisp #35"]
   [:a {:href (r/href :cart)} "Demo App ->"]))
