import React from 'react'
import { Box, Text, Link, Stack, Divider } from '@chakra-ui/react'

function Footer() {
    return (
        <Box bg="gray.800" color="white" p={4} display="flex" justifyContent="center">
            <Stack direction={["column", "row"]} spacing={4} cursor="pointer">
                <Text>Hiring Lab</Text>
                <Text>Career Advice</Text>
                <Text>Browse Jobs</Text>
                <Text>Browse Companies</Text>
                <Text>Salaries</Text>
                <Text>Events</Text>
                <Text>Work with Us</Text>

                <Text>Countries</Text>
                <Text>About</Text>
                <Text>Help</Text>
                <Text>Post a Job</Text>
            </Stack>
        </Box>
    )
}

export default Footer
