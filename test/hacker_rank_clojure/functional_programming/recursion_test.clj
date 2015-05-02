(ns hacker-rank-clojure.functional-programming.recursion-test
  (:require [clojure.test :refer :all]
            [hacker-rank-clojure.functional-programming.recursion :refer :all]))

;; GCD(1,5) = 1
;; GCD(10,100) = 10
;; GCD(22,131) = 1

;; Computing the GCD

(deftest test-first-sample-return-value
  (testing "Verify first given sample works properly"
    (is (= 1 (GCD 1 5)))))

(deftest test-second-sample-return-value
  (testing "Verify second given sample works properly"
    (is (= 10 (GCD 10 100)))))

(deftest test-third-sample-return-value
  (testing "Verify third given sample works properly"
    (is (= 1 (GCD 22 131)))))

(deftest test-first-example-from-video
  (testing "Verify first video ample works properly"
    (is (= 5 (GCD 10 45)))))

(deftest test-second-example-from-video
  (testing "Verify second video sample works properly"
    (is (= 3 (GCD 1701 3768)))))
