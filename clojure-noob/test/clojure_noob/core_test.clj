(ns clojure_noob.core_test
  (:require [clojure.test :refer :all]
            [clojure_noob.core :refer :all])
  )

(deftest a-test
  (testing "Average function works just fine"
    (is (= (avarage [1 2 3 4 -1 3]) 12)))
  )
