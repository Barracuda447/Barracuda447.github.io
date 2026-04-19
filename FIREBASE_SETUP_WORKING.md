# Complete Firebase Setup Guide

Follow these steps exactly to enable cross-device sign-in and file syncing.

## Step 1: Create a Firebase Project (5 minutes)

1. Go to https://console.firebase.google.com/
2. Click **"Add project"**
3. Enter name: `inventory-baseline`
4. Uncheck **"Enable Google Analytics"** (optional)
5. Click **"Create project"**
6. Wait for it to finish, then click **"Continue"**

## Step 2: Register Your Web App

1. In your Firebase project, click the **web icon** (looks like `</>`)
2. Enter app name: `Inventory Baseline`
3. Check **"Also set up Firebase Hosting"** (optional but recommended)
4. Click **"Register app"**

## Step 3: Copy Your Firebase Config

You'll see a code snippet like this:

```javascript
const firebaseConfig = {
  apiKey: "AIzaSyDxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
  authDomain: "inventory-baseline-xxxxx.firebaseapp.com",
  projectId: "inventory-baseline-xxxxx",
  storageBucket: "inventory-baseline-xxxxx.appspot.com",
  messagingSenderId: "1234567890123",
  appId: "1:1234567890123:web:abcdef1234567890abcdef"
};
```

**Copy this entire config** - you'll need it in the next step.

## Step 4: Update Your Code

1. In VS Code, open **index.html**
2. Find the line: `const firebaseConfig = {`
3. Replace the ENTIRE firebaseConfig object with your config from Step 3
4. Do the same in **dashboard.html**

## Step 5: Enable Authentication

1. In Firebase Console, go to **Build** → **Authentication**
2. Click **"Get started"**
3. Find **"Email/Password"** provider
4. Click on it, then enable the toggle
5. Click **"Save"**

## Step 6: Set Up Firestore Database

1. Go to **Build** → **Firestore Database**
2. Click **"Create database"**
3. Choose **"Start in test mode"** (we'll secure it next)
4. Select your preferred region (default is fine)
5. Click **"Create"**

## Step 7: Configure Security Rules

1. In Firestore, click the **"Rules"** tab
2. Delete all existing text
3. Paste this:

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Users can only access their own data
    match /users/{userId} {
      allow read, write: if request.auth.uid == userId;
      
      // Users can read/write their own files
      match /files/{fileId} {
        allow read, write: if request.auth.uid == userId;
      }
    }
  }
}
```

4. Click **"Publish"**

## Step 8: Test It

1. Open your site in a browser
2. Create a new account with email and password
3. Upload an Excel file
4. Open your site **on a different device** or **in an incognito window**
5. Sign in with the same email/password
6. Your files should appear!

## Troubleshooting

**"Permission denied" error:**
- Make sure you published the security rules correctly
- Wait 30 seconds and refresh the page

**"Firebase is not defined":**
- Make sure your firebaseConfig is correct in both files
- Check browser console (F12) for specific errors

**Sign-up works but sign-in doesn't:**
- Check that Email/Password authentication is enabled
- Clear browser cache and try again

**Files don't sync to other device:**
- Make sure you're signed in with the same email
- Check Firestore Rules are published
- Wait a moment and refresh

## Questions?

If something doesn't work:
1. Open browser developer tools (F12)
2. Check the Console tab for error messages
3. Look at the exact error - it will tell you what's wrong

That's it! You should now have cross-device sign-in working.
