(ns transit-demo.proto)

(defprotocol TaxInclude
  (-tax-include-price [x]))
