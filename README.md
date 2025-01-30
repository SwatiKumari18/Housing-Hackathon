# Hackathon Event App

This project is an Android app designed for managing a Hackathon event. It incorporates multiple UI elements such as TextView, EditText, Button, RadioButton, SeekBar, Switch, ImageView, ProgressBar, and BottomNavigationView. The app features multiple screens and allows seamless navigation and data passing between them.

## Features

- **UI Components:**
  - TextView
  - EditText
  - Button
  - RadioButton
  - SeekBar
  - Switch
  - ImageView
  - ProgressBar
  - BottomNavigationView

- **Screens:**
  1. **Welcome Screen** – A friendly introduction to the hackathon.
  2. **Explore Screen** – Browse and explore the event schedule and teams.
  3. **Registration Screen** – Multi-step registration form for participants.
  4. **Feedback Screen** – Provide feedback on the event.
  5. **Summary Screen** – Acknowledge successful registration and show collective form data.

- **Multi-Step Registration:**
  - The registration form consists of 2-3 screens:
    - Screen 1: Collect initial participant details.
    - Screen 2: Collect additional team information.
    - Screen 3: Show a summary of the registration form in a presentable format and confirm successful registration.

## App Layout

- **Layouts Used:**
  - Constraint Layout
  - Linear Layout

- **BottomNavigationView:** Used for navigating between:
  - Welcome screen
  - Explore screen
  - Registration screen
  - Feedback screen

## Data Flow

- **Data Passing:** The app ensures that data entered in the registration form (spread across multiple screens) is passed between screens and displayed in a summary format upon completion.
