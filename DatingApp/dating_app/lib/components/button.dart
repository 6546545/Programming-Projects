import 'package:flutter/material.dart';

class Button extends StatelessWidget {
  final void Function()? onTap;
  final Widget child;

  const Button({super.key, required this.onTap, required this.child});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: onTap ,
      child: Container(
        decoration: BoxDecoration(
          color: Theme.of(context).colorScheme.inversePrimary,
          borderRadius: BorderRadius.circular(10)
        ),
        padding: const EdgeInsets.all(10),
        child: child,
      ),
    );
  }
}