# 2FA-auth
Mobile Application for Two Factor Authentication(2FA) with geo location

## Project Overview  

The growing field of IoT-related authentication is rapidly being adopted across industries as internet security becomes increasingly important. Multi-Factor Authentication (MFA) improves security by requiring multiple methods of authentication — such as passwords and one-time passwords (OTPs).  

Two-Factor Authentication (2FA) adds an additional security layer by requiring two identifiers:  
1. **First factor:** Username and password  
2. **Second factor:** A mobile device to complete authentication  

However, users sometimes forget or lose access to their mobile device, making it impossible to authenticate even when they are authorized.  

This project proposes a **location-aware mobile 2FA application** that verifies the device’s location during authentication. If the device is at a trusted location (e.g., home, gym, clubhouse), the user can bypass OTP verification by answering predefined security questions, allowing access to the system without physical device presence.

---

## Features  

- **Android mobile application** for Two-Factor Authentication (2FA)  
- Secure token generation and storage against user accounts  
- **Trusted location management** — add, update, or delete geo-coordinates such as home or office  
- **Fallback authentication** using security questions if OTP is not available  
- **Server-side storage** for user account details, trusted locations, and security question data  
- **Location verification** using device GPS services  

---

## How It Works  

1. The user logs into a system with a username and password (first factor).  
2. The application checks the device’s current location.  
3. If the device is at a **trusted location**, the user is allowed to proceed without OTP.  
4. If not at a trusted location, the user must authenticate using TOTP and security questions.  
5. Users can add or update trusted locations via the mobile app.  

---

## Tech Stack  

- **Platform:** Android  
- **Languages:** Java  
- **Frameworks/Tools:** Android Studio, Gradle  
- **Services:** Mobile location services (GPS), Firebase Cloud Messaging - Google, REST API 
- **Server:** Application server to manage user accounts, trusted locations, and security questions  

---

## Installation  

1. **Clone the repository:**  
   ```bash
   git clone https://github.com/amitne7/auth-web.git;
   cd auth-web
