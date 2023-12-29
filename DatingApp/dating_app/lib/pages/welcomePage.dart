// ignore_for_file: prefer_const_constructors

import 'package:flutter/material.dart';

class WelcomePage extends StatelessWidget {
  const WelcomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).colorScheme.background,
      body: Column(
        children: [
          SizedBox(height: 50),
          Center(
            child: Text(
              "Welcome!",
              style: TextStyle(
                color: Theme.of(context).colorScheme.inversePrimary,
                fontSize: 30,
                fontWeight: FontWeight.bold
              ),
              ),
          ),
          TextField(
            autofocus: true,
            enabled: true,
            decoration: InputDecoration(
              icon: Icon(Icons.person),
              hintText: "Username",
              border: InputBorder(
                borderSide: BorderSide(
                color: Theme.of(context).colorScheme.inversePrimary
              ))
            ),
            

          ),
          
        ],
      ),

    );
  }
}