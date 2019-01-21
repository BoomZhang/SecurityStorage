#include <iostream>
#include <bitset>
#include <string>
#include <fstream>
#include <jni.h>

using namespace std;
typedef bitset<8> byte;
typedef bitset<32> word;


int add(int a,int b){
    return a + b;
}

extern "C"
JNIEXPORT jint JNICALL
Java_zc_neu_com_securitystorage_MainActivity_getInt(JNIEnv *env, jclass type) {

    return 10 + add(3,6);

}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_zc_neu_com_securitystorage_MainActivity_deal(JNIEnv *env, jclass type, jbyteArray j_array) {
    jbyte *c_array = env->GetByteArrayElements(j_array, 0);
    int len_arr = env->GetArrayLength(j_array);
    //2. 具体处理
    jbyteArray c_result = env->NewByteArray(len_arr);
    jbyte buf[len_arr];

    byte bb[16];
    for(int i=0;i<16;i++){
        bb[i] = c_array[i];
    }

    unsigned char* ch = (unsigned char*) bb;
            //c_array = (jbyte*)bb;

    for(int i=0; i<len_arr; i++){
        buf[i] = *(ch + sizeof(unsigned char) * i);
    }
    //3. 释放内存
    env->ReleaseByteArrayElements(j_array, c_array, 0);
    //4. 赋值
    env->SetByteArrayRegion(c_result, 0, len_arr, buf);
    return c_result;

}
