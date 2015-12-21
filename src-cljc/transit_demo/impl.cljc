(ns transit-demo.impl
  (:require [transit-demo.domain.book :as book]
            [transit-demo.proto :as p]
            [transit-demo.domain.book #?@(:cljs [:refer [Book]])]
            [transit-demo.domain.cart #?@(:cljs [:refer [Cart]])])
  #?(:clj (:import [transit_demo.domain.book Book]
                   [transit_demo.domain.cart Cart])))

(defn ceil [x]
  #?(:clj (Math/ceil x)
     :cljs (.ceil js/Math x)))

(extend-protocol p/TaxInclude
  Cart
  (-tax-include-price [self]
    (reduce #(+ %1 (p/-tax-include-price %2))
            0
            (:items self)))
  Book
  (-tax-include-price [self]
    (ceil (* (:price self) 1.08)))

  nil
  (-tax-include-price [x] 0))

(defn tax-include-price [x]
  (p/-tax-include-price x))
