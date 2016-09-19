(ns clojure_noob.core_test
  (:require [clojure.test :refer :all]
            [clojure_noob.common_problems :refer :all]
            [clojure_noob.core :refer :all]))

(deftest a-test
  (testing "Average function works just fine"
    (is (= (avarage [1 2 3 4 -1 3]) 2))))

(deftest a-test-common-problems-factorial
  (testing "Factorial function works just fine"
    (are [input expected]
      (= (factorial input) expected)
      1 1
      5 120
      15 1307674368000)))

(deftest a-test-common-problems-fibonacci
  (testing "Fibonacci function works just fine"
    (are [input expected]
      (= (fibonacci input) expected)
      0 0
      1 1
      2 1
      7 13
      10 55
      18 2584
      26 121393
      150 9969216677189303386214405760200N)))

(deftest a-test-common-problems-prime-numbers
  (testing "prime? function works just fine"
    (are [input expected]
      (= (prime? input) expected)
      2 true
      5 true
      8 false
      4 false
      73 true
      75 false)))