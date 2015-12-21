(ns transit-demo.util.transit
  (:require [cognitect.transit :as transit]
            [transit-demo.domain.book :refer [new-book #?(:cljs Book)]])
  #?(:clj (:import [transit_demo.domain.book Book])))

(def custom-write-handlers
  {Book (transit/write-handler
         (constantly "book")
         (fn [book] ((juxt :id :title :author :price :publisher) book)))})

(def custom-read-handlers
  {"book" (transit/read-handler
           (fn [book] (apply new-book book)))})
