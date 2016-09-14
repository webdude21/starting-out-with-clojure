(ns clojure_noob.core_test
  (:require [clojure.test :refer :all]
            [clojure_noob.common_problems :refer :all]
            [clojure_noob.core :refer :all]))

(deftest a-test
  (testing "Average function works just fine"
    (is (= (avarage [1 2 3 4 -1 3]) 2))))

(deftest a-test-common-problems-factorial
  (testing "Factorial function works just fine"
    (is (= (factorial 1) 1))
    (is (= (factorial 5) 120))
    (is (= (factorial 15) 1307674368000))))

(deftest a-test-common-problems-fibonacci
  (testing "Fibonacci function works just fine"
    (is (= (fibonacci 2) 1))
    (is (= (fibonacci 0) 0))
    (is (= (fibonacci 1) 1))
    (is (= (fibonacci 7) 13))
    (is (= (fibonacci 10) 55))
    (is (= (fibonacci 18) 2584))
    (is (= (fibonacci 26) 121393))))