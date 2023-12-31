// ignore_for_file: prefer_const_constructors

import 'package:dating_app/components/button.dart';
import 'package:flutter/material.dart';

class IntroPage extends StatelessWidget {
  const IntroPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).colorScheme.background,
      body: Column(
        children: [
          //LOGO
          Center(child: SizedBox(height: 150)),
          Icon(
            Icons.airline_seat_recline_normal, 
            size: 72,
            color: Theme.of(context).colorScheme.inversePrimary,
            ),
          const SizedBox(height: 150),


          //TITLE
          Text(
            "APP NAME",
            style: TextStyle(
              fontSize: 30.0,
              color: Theme.of(context).colorScheme.inversePrimary,
              fontWeight: FontWeight.bold
            ),
          ),
          const SizedBox(height: 15),

          //SUBTITILE
          Text(
            "The app the allows your friends to find you love.",
            style: TextStyle(
              color: Theme.of(context).colorScheme.inversePrimary
            ),
          ),
          const SizedBox(height: 30),


          //BUTTON
          Button(
            onTap: () => Navigator.pushNamed(context, '/welcomePage'), 
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: Text(
                "Let's Get Started",
                style: TextStyle(
                  color: Theme.of(context).colorScheme.secondary,
                  fontSize: 14,
                  fontWeight: FontWeight.bold
                ),
                ),
            )

            ),



        ]),    
    );
  }
}