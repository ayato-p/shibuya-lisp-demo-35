(ns transit-demo.impl
  #?(:cljs (:refer-clojure :exclude [+ - * / = < > <= >= zero? pos? neg?]))
  (:require [transit-demo.domain.book :as book]
            [transit-demo.proto :as p]
            #?@(:cljs [[transit-demo.domain.book :refer [Book]]
                       [cljs-numbers.core :refer [+ - * / = < > <= >= bigint bigint? ratio? double? zero? pos? neg?]]]))
  #?(:clj (:import [transit_demo.domain.book Book])))

(extend-protocol p/TaxInclude
  Book
  (-tax-include-price [self] (* (:price self) 1.08)))

(defn tax-include-price [x]
  (p/-tax-include-price x))
