# Lock Status plugin for Cordova Android

This plugin has one function that returns true or false depending if a phone has been unlocked or not.
Building apps with SecureStorage requires the device to have a PIN, pattern, or some kind of password for
starting a session on the device. If the device is locked and you have an app running on kiosk mode where you
can't exit to enter the password, this plugin gives you that information for any action taking.

## Installation 

cordova plugin add cordova-plugin-lockstatus

**Example Usage:**

```js
window.LockStatusPlugin.isDeviceLocked(
    (status) => {
        console.log(status)
    },
    (error) => {
        console.log(error)
    },
)
```

## MIT Licence

Copyright 2024 Onebittech

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
