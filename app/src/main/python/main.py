from robomaster import robot, led, chassis
import time


def check_version():
	try:
		ep_robot = robot.Robot()
		ep_robot.initialize(conn_type="ap")
		version = ep_robot.get_version()
		return version
	except BaseException as e:
		return "Oops. Something wrong....\nMaybe you don't connect to robot?"
	
def test_led():
	try:
		ep_robot = robot.Robot()
		ep_robot.initialize(conn_type="ap")
		ep_led = ep_robot.led
		bright = 1
		for i in range(0, 8):
			ep_led.set_led(comp=led.COMP_ALL, r=bright << i, g=bright << i, b=bright << i, effect=led.EFFECT_ON)
			time.sleep(1)
			print("brightness: {0}".format(bright << i))
		ep_robot.close()
		return "Success"
	except BaseException as e:
		return "Oops. Something wrong....\nMaybe you don't connect to robot?"
	
def test_wheel():
	try:
		ep_robot = robot.Robot()
		ep_robot.initialize(conn_type="ap")
		ep_chassis = ep_robot.chassis
		x_val = 0.5
		y_val = 0.6
		z_val = 90
		ep_chassis.move(x=x_val, y=0, z=0, xy_speed=0.7).wait_for_completed()
		ep_chassis.move(x=-x_val, y=0, z=0, xy_speed=0.7).wait_for_completed()
		ep_chassis.move(x=0, y=-y_val, z=0, xy_speed=0.7).wait_for_completed()
		ep_chassis.move(x=0, y=y_val, z=0, xy_speed=0.7).wait_for_completed()
		ep_chassis.move(x=0, y=0, z=z_val, z_speed=45).wait_for_completed()
		ep_chassis.move(x=0, y=0, z=-z_val, z_speed=45).wait_for_completed()
		ep_robot.close()
		return "Success"
	except BaseException as e:
		return "Oops. Something wrong....\nMaybe you don't connect to robot?"	
	