(ns hacker-rank-clojure.functional-programming.introduction-test
  (:require [clojure.test :refer :all]
            [hacker-rank-clojure.functional-programming.introduction :refer :all]))

;; Evaluating e^x
;;
;; Sample input:
;; (20.0000, 5.0000, 0.5000, -0.5000)
;;
;; Sample output:
;; (2423600.1887, 143.6895, 1.6487, 0.6065)

(deftest test-evaluating-ex-sample-input
  (testing "Verify first given sample works properly"
    (is (= '(2423600.1887, 143.6895, 1.6487, 0.6065)
           (all-eval-ex '(20.0000, 5.0000, 0.5000, -0.5000))))))
