(ns problems)

;List Replication
(def listreplication
  (fn [num lst]
    (apply concat
      (map (fn [x] (repeat num x)) lst))))