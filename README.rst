================================================
 Practical Reader Conditionals & Transit Format
================================================

これは `Lisp Meet Up presented by Shibuya.lisp #35 <http://lisp.connpass.com/event/24249/>`_ で発表した際に使ったデモ用のアプリケーションです。

詳細はブログに書いたのでそちらを読んでください。

`Practical Reader Conditionals & Transit format <http://ayato-p.github.io/blog/2015/12/25/practical_reader_conditionals_transit_format.html>`_

動かし方
========

.. sourcecode:: shell

  $ git clone https://github.com/ayato-p/shibuya-lisp-demo-35.git ./demo
  $ cd ./demo
  $ lein repl
  transit-demo.repl>(go) ;; この後 localhost:3000 にブラウザからアクセスする

全体像
======

.. sourcecode:: shell

  .
  ├── dev-resources
  │   └── local-config.edn
  ├── env
  │   └── dev
  │       ├── clj
  │       │   └── transit_demo
  │       │       └── repl.clj
  │       └── cljs
  │           └── dev.cljs
  ├── figwheel.edn
  ├── LICENSE
  ├── project.clj
  ├── README.rst
  ├── resources
  │   └── public
  │       ├── css
  │       │   └── style.css
  │       └── js
  ├── src
  │   └── transit_demo
  │       ├── components
  │       │   ├── endpoint.clj
  │       │   ├── pre_loader.clj
  │       │   └── webserver.clj
  │       ├── db.clj
  │       ├── handler
  │       │   ├── api.clj
  │       │   ├── cart.clj
  │       │   └── main.clj
  │       ├── middleware_set.clj
  │       ├── system.clj
  │       ├── util
  │       │   ├── handler.clj
  │       │   ├── namespace.clj
  │       │   └── reframe.clj
  │       └── view
  │           ├── cart.clj
  │           ├── layout.clj
  │           └── main.clj
  ├── src-cljc
  │   └── transit_demo
  │       ├── domain
  │       │   ├── book.cljc
  │       │   └── cart.cljc
  │       ├── impl.cljc
  │       ├── proto.cljc
  │       ├── routes.cljc
  │       ├── routing.cljc
  │       ├── util
  │       │   └── transit.cljc
  │       └── view
  │           └── component
  │               └── cart.cljc
  └── src-cljs
      └── transit_demo
          ├── handler
          │   └── cart.cljs
          ├── main.cljs
          └── sub
              └── cart.cljs

  26 directories, 35 files


License
=======

Copyright © 2015 Ayato Nishimura

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
