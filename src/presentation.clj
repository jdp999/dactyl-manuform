(ns presentation
  (:refer-clojure :exclude [use import])
  (:require [scad-clj.scad :refer :all]
            [scad-clj.model :refer :all]
            [unicode-math.core :refer :all]
            [clojure.core.matrix.operators :refer [+ - / *]]))

(def ^:const COMBINED true)
(def x-offset 120)
(def angle 15)

(def left
  (if COMBINED
    (union
      (import "../things/left6x7.stl"))

    (union
      (import "../things/left6x7.stl")
      )))

(def right
  (if COMBINED
    (union
      (import "../things/right6x7.stl")
      )

    (union
      (import "../things/right6x7.stl")
      )))

(def presentation
  (union
    (->> left
         (translate [(- (/ x-offset 2)) 0 0])
         (rotate (/ π angle) [0 0 (- 1)]))
    (->> right
         (translate [(/ x-offset 2) 0 0])
         (rotate (/ π angle) [0 0 1]))))

(spit "things/dactyl-presentation.scad"
  (write-scad presentation))
