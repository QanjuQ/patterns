(ns patterns.core-test
  (:require [clojure.test :refer :all]
            [patterns.core :refer :all]))

(deftest solid-rectangle-test
  (testing "A solid rectangle with length and width 4,5 respectively"
    (is (= '(("*" "*" "*" "*" "*")
             ("*" "*" "*" "*" "*")
             ("*" "*" "*" "*" "*")
             ("*" "*" "*" "*" "*"))
           (solid-rectangle 4 5))))
  
  (testing "A solid rectangle with length and width 3,2 respectively"
    (is (= '(("*" "*" "*")
             ("*" "*" "*"))
           (solid-rectangle 3 2)))))

(deftest hollow-rectangle-test
  (testing "A hollow rectangle with length and width 4,5 respectively"
    (is (= '(("*" "*" "*" "*" "*")
             ("*" " " " " " " "*")
             ("*" " " " " " " "*")
             ("*" "*" "*" "*" "*"))
           (hollow-rectangle 4 5))))
  
  (testing "A solid rectangle with length and width 3,2 respectively"
    (is (= '(("*" "*" "*")
             ("*" "*" "*"))
           (hollow-rectangle 3 2)))))

(deftest left-triangle-test 
  (testing "A triangle of width and height 6"
    (is (= '(("*")
             ("*" "*")
             ("*" "*" "*")
             ("*" "*" "*" "*")
             ("*" "*" "*" "*" "*")
             ("*" "*" "*" "*" "*" "*"))
             (left-triangle 6))))
  (testing "A triangle of width and height 3"
    (is (= '(("*")
             ("*" "*")
             ("*" "*" "*"))
             (left-triangle 6)))))

(deftest right-triangle-test
  (testing "A triangle of width and height 6"
    (is (= '((" " " " "*")
             (" " "*" "*")
             ("*" "*" "*"))
             (right-triangle 4)))))
