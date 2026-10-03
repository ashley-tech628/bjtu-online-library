<script lang="ts" setup>
import router from "@/common/router";
const toPath = router.currentRoute.value.query.toPath as string
router.replace({path: toPath})
</script>