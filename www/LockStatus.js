exec = require('cordova/exec')

module.exports = {
    isDeviceLocked(resolve, reject) {
        exec(resolve, reject, 'LockStatus', 'isDeviceLocked', [])
    }
}