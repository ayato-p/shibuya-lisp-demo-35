(ns transit-demo.view.layout
  (:require [hiccup.page :refer [html5 include-js]]))

(defn common-layout [& contents]
  (html5
   [:head
    [:title "Transit Demo"]
    (include-js "/js/main.js")]
   [:body
    contents]))
