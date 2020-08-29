(ns dataseek.dataseek-test
  (:require [cljs.test :refer [deftest is]]
            [dataseek.core :as core]))

(deftest example-test
  (is (= "Hello, World!" (core/greet "World"))))

