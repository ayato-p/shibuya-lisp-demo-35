(ns transit-demo.impl
  (:require [transit-demo.domain.book :as book]
            [transit-demo.proto :as p]
            #?(:cljs [transit-demo.domain.book :refer [Book]]))
  #?(:clj (:import [transit_demo.domain.book Book])))

(extend-protocol p/TaxInclude
  Book
  (-tax-include-price [self] (* (:price self) 1.08)))

(defn tax-include-price [x]
  (p/-tax-include-price x))
