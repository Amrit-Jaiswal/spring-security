How to create key-store and trust-store

To create keystore
=> keytool -genkey -keyalg RSA -alias aliasname -keystore keystore.jks -validity 365 -keysize 2048

Verify content of keystore
=> keytool -list -v -keystore keystore.jks
