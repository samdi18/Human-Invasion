# Human-Invasion-game
 
Class & Method Description:

Frame class: 
The Frame class has been used to display the game window. It also includes the main method of the program.

Creature class: 
The Creature class is an abstract class providing a guideline to the Alien and BadHuman class with the abstract methods : move() and getBounds().

FireBullet class: 
The FireBullet class is used to get the bullet image and it has a boolean variable ‘visible’ with setter getters to control visibility.

Alien class: 
The Alien class extends the Creatures class, it also loads the enemy image. The ‘move()’ method enables the Alien object to move in one direction.

BadHuman class: 
The BadHuman class extends the Creatures class, it also loads the player image. The ‘move()’ method enables the the character to be moved across the screen.

Game class: 
The Game class extends the JPanel and class implements the Runnable and ActionListener interfaces .The ActionListener interface is used for animation ,character or object generation is done here. The ‘paint()’ method is used to draw all the objects on the screen. The ‘actionPerformed()’ method controls all the actions performed. The ‘CheckCollision()’ method checks the collision between the objects by accessing the ‘getBounds()’ method from their respected classes. The ‘jump()’ method is used to make the character jump using a boolean value for the ‘maxHeight’ to control the jump which is confirmed when the vertical position of the character reaches the maximum height which we have set. And to fall back down to the initial position which we increment using the same variable ‘v’.



