(ns transit-demo.routes)

(def main
  ["/" {"" {"" :home
            "cart" :cart}
        "api" {"/book" {"/search" :api/search-book}}}])
