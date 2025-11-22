package hua.huase.shanhaicontinent.api;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import yesman.epicfight.api.utils.math.Vec3f;

/**
 * - @description:ShapeUtil类
 * - @author: huase。
 * - @date: 2025/11/13 12:44
 */
public class ShapeUtil {

    public static void drawQuad(PoseStack poseStack, VertexConsumer vertexBuilder, Vec3f pos, float size, float r, float g, float b) {
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y, pos.z - size).color(r, g, b, 1.0F).endVertex();
    }

    public static void drawCube(PoseStack poseStack, VertexConsumer vertexBuilder, Vec3f pos, float size, float r, float g, float b) {
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y - size, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y - size, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y - size, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y - size, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y + size, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y + size, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y + size, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y + size, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y + size, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y + size, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y - size, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y - size, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y + size, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y + size, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y - size, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y - size, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y + size, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y + size, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y - size, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y - size, pos.z - size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y + size, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y + size, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x - size, pos.y - size, pos.z + size).color(r, g, b, 1.0F).endVertex();
        vertexBuilder.vertex(poseStack.last().pose(), pos.x + size, pos.y - size, pos.z + size).color(r, g, b, 1.0F).endVertex();
    }
    /**
     * 获取立方体顶点坐标和UV坐标数据
     *
     * @param length 立方体长度
     * @param width 立方体宽度
     * @param height 立方体高度
     * @return 包含顶点坐标和UV坐标的二维数组
     */
    public static float[][] getCubeVertices(float length, float width, float height) {
        float halfLength = length / 2.0f;
        float halfWidth = width / 2.0f;
        float halfHeight = height / 2.0f;

        // 创建包含顶点坐标和UV坐标的数组
        // 每个顶点包含：X, Y, Z, U, V 共5个数据
        float[][] verticesWithUV = new float[24][5];
        int index = 0;

        // 前面 (Z = -halfHeight)
        verticesWithUV[index++] = new float[]{-halfLength, -halfWidth, -halfHeight, 0.0f, 0.0f};
        verticesWithUV[index++] = new float[]{halfLength, -halfWidth, -halfHeight, 1.0f, 0.0f};
        verticesWithUV[index++] = new float[]{halfLength, halfWidth, -halfHeight, 1.0f, 1.0f};
        verticesWithUV[index++] = new float[]{-halfLength, halfWidth, -halfHeight, 0.0f, 1.0f};

        // 后面 (Z = halfHeight)
        verticesWithUV[index++] = new float[]{-halfLength, -halfWidth, halfHeight, 0.0f, 0.0f};
        verticesWithUV[index++] = new float[]{-halfLength, halfWidth, halfHeight, 0.0f, 1.0f};
        verticesWithUV[index++] = new float[]{halfLength, halfWidth, halfHeight, 1.0f, 1.0f};
        verticesWithUV[index++] = new float[]{halfLength, -halfWidth, halfHeight, 1.0f, 0.0f};

        // 左面 (X = -halfLength)
        verticesWithUV[index++] = new float[]{-halfLength, -halfWidth, -halfHeight, 0.0f, 0.0f};
        verticesWithUV[index++] = new float[]{-halfLength, -halfWidth, halfHeight, 1.0f, 0.0f};
        verticesWithUV[index++] = new float[]{-halfLength, halfWidth, halfHeight, 1.0f, 1.0f};
        verticesWithUV[index++] = new float[]{-halfLength, halfWidth, -halfHeight, 0.0f, 1.0f};

        // 右面 (X = halfLength)
        verticesWithUV[index++] = new float[]{halfLength, -halfWidth, -halfHeight, 0.0f, 0.0f};
        verticesWithUV[index++] = new float[]{halfLength, halfWidth, -halfHeight, 1.0f, 1.0f};
        verticesWithUV[index++] = new float[]{halfLength, halfWidth, halfHeight, 1.0f, 1.0f};
        verticesWithUV[index++] = new float[]{halfLength, -halfWidth, halfHeight, 0.0f, 1.0f};

        // 下面 (Y = -halfWidth)
        verticesWithUV[index++] = new float[]{-halfLength, -halfWidth, -halfHeight, 0.0f, 0.0f};
        verticesWithUV[index++] = new float[]{-halfLength, -halfWidth, halfHeight, 0.0f, 1.0f};
        verticesWithUV[index++] = new float[]{halfLength, -halfWidth, halfHeight, 1.0f, 1.0f};
        verticesWithUV[index++] = new float[]{halfLength, -halfWidth, -halfHeight, 1.0f, 0.0f};

        // 上面 (Y = halfWidth)
        verticesWithUV[index++] = new float[]{-halfLength, halfWidth, -halfHeight, 0.0f, 0.0f};
        verticesWithUV[index++] = new float[]{halfLength, halfWidth, -halfHeight, 1.0f, 0.0f};
        verticesWithUV[index++] = new float[]{halfLength, halfWidth, halfHeight, 1.0f, 1.0f};
        verticesWithUV[index++] = new float[]{-halfLength, halfWidth, halfHeight, 0.0f, 1.0f};

        return verticesWithUV;
    }

}
