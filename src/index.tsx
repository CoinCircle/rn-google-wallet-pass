import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'rn-google-wallet-pass' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const RnGoogleWalletPass =
  Platform.OS !== 'android'
    ? {}
    : NativeModules.RnGoogleWalletPass ??
      new Proxy(
        {},
        {
          get() {
            throw new Error(LINKING_ERROR);
          },
        }
      );

export async function isSupported(): Promise<Boolean> {
  return await RnGoogleWalletPass.isSupported();
}

/*
 * Pass: stringified json
 */
export async function addWalletPass(pass: String): Promise<Boolean> {
  return await RnGoogleWalletPass.addWalletPass(pass);
}
