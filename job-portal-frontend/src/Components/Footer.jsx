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
                <Text className="sm:text-base md:text-lg lg:text-xl hover:font-semibold">Hiring Lab</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl hover:font-semibold">Career Advice</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl hover:font-semibold">Browse Jobs</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl hover:font-semibold">Browse Companies</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl hover:font-semibold">Salaries</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl hover:font-semibold">Events</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl hover:font-semibold">Work with Us</Text>

                <Text className="sm:text-base md:text-lg lg:text-xl hover:font-semibold">Countries</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl hover:font-semibold">About</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl hover:font-semibold">Help</Text>
                <Text className="sm:text-base md:text-lg lg:text-xl hover:font-semibold">Post a Job</Text>

            </Stack>
        </Box>
    )
}

export default Footer
