import { View, Text, TextInput, TouchableOpacity } from "react-native";
import React from "react";
import styles from "@/components/styles";

const resetPassword = () => {
  return (
    <View className={styles.centerContainer}>
      <Text className={styles.title}>Reset Password</Text>
      <View className="my-8">
        <View className={styles.inputContainer}>
          <Text className={styles.text}>New Password</Text>
          <TextInput className={styles.form} placeholder="********" />
        </View>
        <View className={styles.inputContainer}>
          <Text className={styles.text}>New Password Confirmation</Text>
          <TextInput className={styles.form} placeholder="********" />
        </View>
      </View>
      <TouchableOpacity className={styles.action}>
        <Text className={styles.btnTextWhite}>Reset Password</Text>
      </TouchableOpacity>
    </View>
  );
};

export default resetPassword;
