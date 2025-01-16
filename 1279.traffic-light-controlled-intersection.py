#
# @lc app=leetcode id=1279 lang=python3
#
# [1279] Traffic Light Controlled Intersection
#

# @lc code=start
class TrafficLight:
    def __init__(self):
        pass

    def carArrived(
        self,
        carId: int,                      # ID of the car
        roadId: int,                     # ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        direction: int,                  # Direction of the car
        turnGreen: 'Callable[[], None]', # Use turnGreen() to turn light to green on current road
        crossCar: 'Callable[[], None]'   # Use crossCar() to make car cross the intersection
    ) -> None:
        
# @lc code=end

