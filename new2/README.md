Paper Prototype UI
==================

The UI in this repository is for a paper prototyping assignment for ICS 314.  It is a prototype UI for google's self driving car.

Description of UI
==================
The theme of this UI is following along with google's Android OS.  At it's very center the UI combines google maps and Android OS's quickstart bar.  Google maps handles all the navigation features: tracking the vehicle on a map, selecting routes, route alerts (traffic, road closures, toll roads, etc), alternative route selection, route distance, travel time estimation and frequently travelled locations (bookmarks).  Input is primarily through voice (voice icon above quickstart bar activates microphone), but there is also a touchscreen keyboard backup.

Some of the other features required for a car are added on as additional buttons on the base UI (ui_base.png).  The top right contains emergency actions (the red stop sign).  It brings up a menu (emergency.png) which allows for police/hospital and pulling over.  Car information on mileage, engine alerts, amount of gasoline are located in the "car tracker" app, this can be accessed on the android quickstart bar (steering wheel icon on the bottom right).  In our preliminary version setting the car's max speed is also through this app.

Standard android apps are available (chrome, google now cards, etc) and many standard car features make an appearance as a google android app (phone call, contacts, music).  One final feature is the car startup sequence: our UI for starting the car has a lot of self diagnostics and a login page (see diag.jpg and login.png).

For more details see each individual screenshot and see flowchart.txt to see how the screens are linked together.