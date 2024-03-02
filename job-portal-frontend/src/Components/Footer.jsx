/**
 * Ayush Thapa
 * Footer Component
 */
import React from 'react'
import { Box, Text, Link, Stack, Divider } from '@chakra-ui/react'

function Footer() {
    return (
        <Box bg="gray.800" color="white" p={4} display="flex" justifyContent="center">
            <Stack direction={["column", "row"]} spacing={4} cursor="pointer">
                <Text className="sm:text-base md:text-lg lg:text-xl">Hiring Lab</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl">Career Advice</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl">Browse Jobs</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl">Browse Companies</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl">Salaries</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl">Events</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl">Work with Us</Text>

                <Text className="sm:text-base md:text-lg lg:text-xl">Countries</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl">About</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl">Help</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl">Post a Job</Text>

            </Stack>
        </Box>
    )
}

export default Footer
