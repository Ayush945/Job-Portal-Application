import { Box, Button, Flex, Heading, Spacer, Text } from '@chakra-ui/react';
import React from 'react';
import { Link } from 'react-router-dom';

function Navbar() {
    return (
        <Box as="nav" bg="#BED9F8" py={4} px={8} display="flex" alignItems="center" justifyContent="space-between">
            <Heading fontSize="xl" className=' hover:cursor-pointer'>Job Portal</Heading>
            <Flex gap={4}>
                <Link to={'/'} className=' hover:text-white cursor-pointer'>Home</Link>
                <Link to={'/find-companies'} className=' hover:text-white'>Company Review</Link>
                <Link to={'/find-salaries'} className=' hover:text-white'>Salaries</Link>
            </Flex>
            <Flex gap={4}>
                <Button variant="ghost" as={Link} to={'message'}>Message</Button>
                <Button variant="ghost" as={Link} to={'notification'}>Notification</Button>
                <Button variant="ghost" as={Link} to={'profile'}>Profile</Button>
            </Flex>
            <Button variant="outline" borderWidth={3} as={Link} to={'post-job'}>Post Job</Button>
        </Box>
    );
}

export default Navbar;
