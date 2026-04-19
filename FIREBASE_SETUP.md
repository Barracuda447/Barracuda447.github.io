# Firebase Setup Guide

Your Inventory Baseline app now uses **Firebase** for cross-device sign-in and cloud storage. Follow these steps to set it up:

## Step 1: Create a Firebase Project

1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Click **"Add project"**
3. Enter project name: **inventory-baseline** (or your preferred name)
4. Click **"Create project"** and wait for it to finish

## Step 2: Create a Web App

1. In your Firebase project, click the **Web icon** (</>) to create a web app
2. Enter app name: **Inventory Baseline**
3. Check **"Also set up Firebase Hosting"** (optional)
4. Click **"Register app"**
5. Firebase will show you your **config object** - copy this entire config

## Step 3: Update Configuration in Your Code

You'll see a config object that looks like this:
```javascript
const firebaseConfig = {
  apiKey: "YOUR_API_KEY",
  authDomain: "YOUR_AUTH_DOMAIN",
  projectId: "YOUR_PROJECT_ID",
  storageBucket: "YOUR_STORAGE_BUCKET",
  messagingSenderId: "YOUR_MESSAGING_SENDER_ID",
  appId: "YOUR_APP_ID"
};
```

Replace the placeholder config in **both** files:
- **index.html** (around line 9)
- **dashboard.html** (around line 10)

## Step 4: Enable Authentication

1. In Firebase Console, go to **Authentication** → **Sign-in method**
2. Click **Email/Password** and enable it
3. Click **Save**

## Step 5: Set Up Firestore Database

1. In Firebase Console, go to **Firestore Database**
2. Click **Create database**
3. Choose **Start in production mode**
4. Select your preferred region
5. Click **Create**

## Step 6: Configure Firestore Security Rules

Replace the default Firestore rules with these:

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Allow users to create and manage their own profile
    match /users/{userId} {
      allow read, write: if request.auth.uid == userId;
      
      // Allow users to manage their own files
      match /files/{document=**} {
        allow read, write: if request.auth.uid == userId;
      }
    }
  }
}
```

Steps to add rules:
1. In Firestore Database, click **Rules** tab
2. Replace all text with the rules above
3. Click **Publish**

## Step 7: Test It Out!

1. Go to your site and create an account
2. Sign in from another device using the same email/password
3. Upload a file
4. Check from the other device - your files should appear!

## Troubleshooting

**"Firebase is not defined"**
- Make sure Firebase SDK scripts are loading properly in the `<head>` section

**"Permission denied" errors**
- Check that Firestore security rules are properly published
- Make sure you copied the exact config values

**Sign-in doesn't work**
- Verify Email/Password is enabled in Firebase Authentication
- Check browser console for specific error messages (F12)

**Files not saving**
- Check that Firestore database is created
- Verify security rules allow your user to write data

## Notes

- Each user's data is isolated and only accessible to them
- Files are stored in Firestore with their data preserved
- Users can sign in from any device using their email and password
- All data is encrypted in transit and at rest by Firebase
