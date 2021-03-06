(ns clojure_noob.core
  (:gen-class))

; curryable pow function
(defn pow [x]
  (fn [y] (int (Math/pow x y))))

(defn average [numbers]
  (/ (apply + numbers) (count numbers)))

(defn -main [& args]
  ; curried version of sum with 2
  (def sumWithTwo (partial + 2))
  ; curried version to expand a value to the power of 10
  (def toThePowerOf10 (pow 10))

  (def someNumbers [60 80 100 400])

  (printf "Average of %s is %d%n" someNumbers (average someNumbers))
  (println (map sumWithTwo [1 3 4 5 6]))
  (println (map toThePowerOf10 [1 3 4 5 6])))