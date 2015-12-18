(ns transit-demo.view.main
  (:require [transit-demo.view.layout :as layout]))

(defn main []
  (layout/common-layout
   [:h1 "Clojure Books!!"]
   [:div#cljs-app]))
