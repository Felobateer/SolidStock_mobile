import { View, Text, TextInput, TouchableOpacity } from "react-native";
import React from "react";
import styles from "@/components/styles";
import { useRouter } from "expo-router";

const forgotPassword = () => {
  const router = useRouter();
  const handlePress = () => {
    router.push("/(auth)/reset_password");
  };
  return (
    <View className={styles.centerContainer}>
      <Text className={styles.title}>Forgot Password</Text>
      <View className="my-10">
        <View className={styles.inputContainer}>
          <Text className={styles.text}>Email</Text>
          <TextInput
            className={styles.form}
            placeholder="example@solidstock.com"
          />
        </View>
      </View>
      <TouchableOpacity className={styles.action} onPress={handlePress}>
        <Text className={styles.btnTextWhite}>Send Email</Text>
      </TouchableOpacity>
    </View>
  );
};

export default forgotPassword;
