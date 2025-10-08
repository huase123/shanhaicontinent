#version 150


uniform float     GameTime;

in vec2 texCoord0;
in vec4 vertexColor;

out vec4 fragColor;

float circle(in float radius_r, in float r){

    float f1 = 0.01;
    //     动态模糊效果
    return smoothstep(radius_r-f1,radius_r+f1,r);
    // return step(radius_r,r);

}

float handcircle(in float a, in float r, in float d, in float y, in float w, in float n, in float time){
    //     d对称数
    //     y衍生参数
    a +=time*240.0F/d;
    float f1 = r*y;
    float f = f1 *cos(sin(a*d)*1.232);

    float f2 = circle(0.432,f) -circle(0.460,f);
    //     显示范围
    float f3 = circle(r,w) *circle(n,r);
    float crele3 =f3 * f2;

    return crele3;
}

void main() {
    vec2 st = texCoord0;
    vec3 color = vec3(0.0);

    vec2 pos = vec2(0.5)-st;

    float r = length(pos)*1.344;
    float a = atan(pos.y,pos.x);

    float crele1 = circle(0.48, r) -circle(0.5, r);
    float crele2 = circle(0.540, r) -circle(0.55, r);


    // float crele3 =f3 * f2;
    float crele3 =handcircle(a,r,
    16.0,
    2.616,
    0.776,
    0.476,
    -GameTime);
    float crele4 =handcircle(a,r,
    8.0,
    2.144,
    0.776,
    0.444,
    GameTime);

    float crele5 =handcircle(a,r,
    4.0,
    2.608,
    0.776,
    0.484,
    GameTime);
    float crele6 =handcircle(a*2.0,r,
    4.0,
    1.096,
    0.496,
    0.236,
    GameTime);
    float crele7 =handcircle(a*2.0,r,
    4.0,
    0.944,
    0.552,
    0.308,
    GameTime);

    // float crele = crele3;
    // float crele = crele1+crele2 ;
    float crele = crele1+crele2 +crele3+crele4+crele5+crele6+crele7;
    color = vec3(crele);

    if (crele == 0.0) {
        discard;
    }
    fragColor = vec4(color,crele)*vertexColor;

}
