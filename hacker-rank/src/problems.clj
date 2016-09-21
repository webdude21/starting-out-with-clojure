(ns problems)

;List Replication
(def list-replication
  (fn [num lst]
    (apply concat (map (fn [x] (repeat num x)) lst))))

;Filter list
(def filter-list
  (fn [delim lst]
    (filter #(< % delim) lst)))

;Filter out odd
(def filter-odd
  (fn [lst]
    (keep-indexed #(if (odd? %1) %2) lst)))

;List of n elements
(def item-replication
  (fn [n]
    (repeat n n)))

;List reverse
(def list-reverse
  (fn [lst]
    (reverse lst)))

;Sum of odd elements
(def sum-odd
  (fn [lst]
    (reduce + (filter odd? lst))))

;Size of a list
(def get-list-size
  (fn[lst]
    (count lst)))

;Abs of list values
(def get-abs-values-list
   (fn [lst]
     (map (fn [num] (Math/abs num)) lst)))