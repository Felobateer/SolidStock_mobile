import { View, Text, TextInput, TouchableOpacity } from "react-native";
import React from "react";
import styles from "@/components/styles";
import GradientLine from "@/components/linearGradient";
import { Link, useRouter } from "expo-router";

const LoginScreen = () => {
  const navigation = useRouter();

  const handlePress = () => {
    console.log("btn pressed!");
  };

  return (
    <View className={styles.centerContainer}>
      <View className="mb-5">
        <Text className={styles.title}>Login</Text>
      </View>
      <View>
        <Text className={styles.text}>Username</Text>
        <TextInput
          className={styles.form}
          placeholder="example@solidstock.com"
        />
      </View>
      <View>
        <Text className={styles.text}>Password</Text>
        <TextInput className={styles.form} placeholder="**********" />
      </View>
      <View className="flex flex-col justify-center items-center">
        <TouchableOpacity className={styles.action} onPress={handlePress}>
          <Text className={styles.btnTextWhite}>Login</Text>
        </TouchableOpacity>
        <TouchableOpacity className={styles.action} onPress={handlePress}>
          <Text className={styles.btnTextWhite}>Continue with Google</Text>
        </TouchableOpacity>
      </View>
      <GradientLine />
      <View className="flex flex-row justify-center items-center">
        <Text className={styles.text + "text-center"}>
          Don't have an account
        </Text>
        <TouchableOpacity
          className={styles.action}
          onPress={() => navigation.push("/(auth)/signup")}
        >
          <Text className={styles.btnTextWhite}>Sign in</Text>
        </TouchableOpacity>
      </View>
      <View className="flex items-center justify-center">
        <Link
          href={"/(auth)/forgot_password"}
          className={styles.smText + "text-center"}
        >
          Forgot Password?
        </Link>
      </View>
    </View>
  );
};

export default LoginScreen;
