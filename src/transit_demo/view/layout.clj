(ns transit-demo.view.layout
  (:require [hiccup.page :refer [html5 include-js include-css]]))

(defn common-layout [& contents]
  (html5
   [:head
    [:title "Transit Demo"]
    (include-css "/css/style.css")]
   [:body
    contents
    (include-js "/js/main.js")]))
